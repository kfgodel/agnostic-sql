package ar.com.kfgodel.asql.impl.vendors;

import ar.com.kfgodel.asql.api.AStatement;
import ar.com.kfgodel.asql.api.VendorDialect;
import ar.com.kfgodel.asql.impl.templating.DefaultTypeMapper;
import ar.com.kfgodel.asql.impl.templating.FreemarkerEngine;
import ar.com.kfgodel.asql.impl.templating.TemplateEngine;
import ar.com.kfgodel.asql.impl.tree.ScriptNode;
import ar.com.kfgodel.asql.impl.tree.TemplateUsable;

import java.util.List;

/**
 * This type represents a vendor specific dialect that translates agnostic statements
 * Created by kfgodel on 12/07/15.
 */
public class VendorSpecificDialect implements VendorDialect {

    private TemplateEngine templating;

    @Override
    public String translate(AStatement statement) {
        TemplateUsable representationNode =  statement.getRepresentationNode();
        return translateWithTemplate(representationNode);
    }

    private String translateWithTemplate(TemplateUsable node) {
        return templating.process(node);
    }

    @Override
    public String translate(List<AStatement> statements) {
        ScriptNode scriptNode = groupStatementsInAScriptNode(statements);
        return translateWithTemplate(scriptNode);
    }

    /**
     * Creates a script representation with the translated statements
     * @param statements The statements to group
     * @return The node representing a script
     */
    private ScriptNode groupStatementsInAScriptNode(List<AStatement> statements) {
        ScriptNode scriptNode = ScriptNode.create();
        for (AStatement aStatement : statements) {
            String translated = this.translate(aStatement);
            scriptNode.addStatement(translated);
        }
        return scriptNode;
    }

    public static VendorSpecificDialect create(String vendorSpecificDir) {
        VendorSpecificDialect dialect = new VendorSpecificDialect();
        dialect.templating = FreemarkerEngine.create(vendorSpecificDir, DefaultTypeMapper.create());
        return dialect;
    }


}
