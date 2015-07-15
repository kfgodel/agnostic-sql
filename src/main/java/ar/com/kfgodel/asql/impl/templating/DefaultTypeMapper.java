package ar.com.kfgodel.asql.impl.templating;

import ar.com.kfgodel.asql.api.AsqlException;
import ar.com.kfgodel.asql.impl.model.ScriptModel;
import ar.com.kfgodel.asql.impl.model.add.AddColumnModel;
import ar.com.kfgodel.asql.impl.model.create.CreateModel;
import ar.com.kfgodel.asql.impl.model.update.UpdateModel;

import java.util.LinkedHashMap;

/**
 * This type represents the default mapping between node types and templates
 * Created by kfgodel on 12/07/15.
 */
public class DefaultTypeMapper implements TypeToTemplateMapper {

    private LinkedHashMap<Class<? extends TemplateReferable>, String> templateNamePerType;

    private void initialize(){
        templateNamePerType.put(ScriptModel.class, "script.ftl");
        templateNamePerType.put(UpdateModel.class, "update.ftl");
        templateNamePerType.put(CreateModel.class, "create.ftl");
        templateNamePerType.put(AddColumnModel.class, "add_column.ftl");
    }

    public static DefaultTypeMapper create() {
        DefaultTypeMapper mapper = new DefaultTypeMapper();
        mapper.templateNamePerType = new LinkedHashMap<>();
        mapper.initialize();
        return mapper;
    }

    @Override
    public String getTemplateNameFor(TemplateReferable templateModel) {
        if(templateModel == null){
            throw new AsqlException("The model cannot be null. There's no template for null");
        }
        Class<?> modelType = templateModel.getClass();
        String templateName = templateNamePerType.get(modelType);
        if(templateName == null){
            throw new AsqlException("There's no template defined for type["+modelType+"]");
        }
        return templateName;
    }
}
