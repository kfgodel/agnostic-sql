package ar.com.kfgodel.asql.impl.vendors;

import ar.com.kfgodel.asql.api.AgnosticStatement;
import ar.com.kfgodel.asql.api.VendorDialect;
import ar.com.kfgodel.asql.impl.templating.DefaultTypeMapper;
import ar.com.kfgodel.asql.impl.templating.FreemarkerEngine;
import ar.com.kfgodel.asql.impl.templating.TemplateEngine;
import ar.com.kfgodel.asql.impl.tree.ScriptModel;
import ar.com.kfgodel.asql.impl.templating.TemplateReferable;

import java.util.List;

/**
 * This type represents a vendor specific dialect that translates agnostic statements
 * Created by kfgodel on 12/07/15.
 */
public class VendorSpecificDialect implements VendorDialect {

    private TemplateEngine templating;

    @Override
    public String translate(AgnosticStatement statement) {
        TemplateReferable representationNode =  statement.parseModel();
        return translateWithTemplate(representationNode);
    }

    private String translateWithTemplate(TemplateReferable node) {
        return templating.process(node);
    }

    @Override
    public String translate(List<AgnosticStatement> statements) {
        ScriptModel scriptModel = groupStatementsInAScriptNode(statements);
        return translateWithTemplate(scriptModel);
    }

    /**
     * Creates a script representation with the translated statements
     * @param statements The statements to group
     * @return The node representing a script
     */
    private ScriptModel groupStatementsInAScriptNode(List<AgnosticStatement> statements) {
        ScriptModel scriptModel = ScriptModel.create();
        for (AgnosticStatement agnosticStatement : statements) {
            String translated = this.translate(agnosticStatement);
            scriptModel.addStatement(translated);
        }
        return scriptModel;
    }

    public static VendorSpecificDialect create(String vendorSpecificDir) {
        VendorSpecificDialect dialect = new VendorSpecificDialect();
        dialect.templating = FreemarkerEngine.create(vendorSpecificDir, DefaultTypeMapper.create());
        return dialect;
    }


}
