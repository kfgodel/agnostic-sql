<#include "/macros/_renderAsModel.ftl" />
<#if model.optionalName??>CONSTRAINT${" "}<@renderAsModel model=model.optionalName/>${" "}</#if>
${model.typeName} (
<#list model.columns as column>
<@renderAsModel model=column/><#sep>, </#sep>
</#list>
) <#if model.tail??>${model.tail}</#if>