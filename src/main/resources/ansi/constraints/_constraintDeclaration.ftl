${model.typeName} (
<#list model.columnNames as columnName>
${columnName}<#sep>, </#sep>
</#list>
) <#if model.tail??>${model.tail}</#if>