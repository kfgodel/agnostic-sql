<#include "/macros/_renderAsModel.ftl" />
${model.typeName} (
<#list model.columns as column>
<@renderAsModel model=column/><#sep>, </#sep>
</#list>
) <#if model.tail??>${model.tail}</#if>