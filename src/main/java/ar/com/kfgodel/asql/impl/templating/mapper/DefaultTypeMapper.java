package ar.com.kfgodel.asql.impl.templating.mapper;

import ar.com.kfgodel.asql.api.AsqlException;
import ar.com.kfgodel.asql.impl.model.ScriptModel;
import ar.com.kfgodel.asql.impl.model.delete.DeleteModel;
import ar.com.kfgodel.asql.impl.model.drop.DropModel;
import ar.com.kfgodel.asql.impl.model.types.TypeReference;
import ar.com.kfgodel.asql.impl.model.alter.AddColumnModel;
import ar.com.kfgodel.asql.impl.model.create.CreateModel;
import ar.com.kfgodel.asql.impl.model.alter.RemoveColumnModel;
import ar.com.kfgodel.asql.impl.model.update.UpdateModel;
import ar.com.kfgodel.asql.impl.templating.TemplateReferable;

import java.util.LinkedHashMap;

/**
 * This type represents the default mapping between node types and templates
 * Created by kfgodel on 12/07/15.
 */
public class DefaultTypeMapper implements TypeToTemplateMapper {

    private LinkedHashMap<Class<? extends TemplateReferable>, String> templateNamePerType;

    private void initialize(){
        templateNamePerType.put(ScriptModel.class, "script.ftl");
        templateNamePerType.put(UpdateModel.class, "update/update.ftl");
        templateNamePerType.put(CreateModel.class, "create/create.ftl");
        templateNamePerType.put(AddColumnModel.class, "alter/add_column.ftl");
        templateNamePerType.put(RemoveColumnModel.class, "alter/remove_column.ftl");
        templateNamePerType.put(TypeReference.class, "columns/_columnType.ftl");
        templateNamePerType.put(DeleteModel.class, "delete/delete.ftl");
        templateNamePerType.put(DropModel.class, "drop/drop.ftl");
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
