${constraintDeclaration.typeName} (
<#list constraintDeclaration.columnNames as columnName>
${columnName}<#sep>, </#sep>
</#list>
) <#if constraintDeclaration.tail??>${constraintDeclaration.tail}</#if>