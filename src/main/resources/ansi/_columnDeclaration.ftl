${columnDeclaration.columnName} <#assign type=columnDeclaration.columnType><#include "_columnType.ftl"/>
<#if columnDeclaration.nullity??>
${columnDeclaration.nullity}
</#if>
<#if columnDeclaration.defaultValue??>
DEFAULT <#assign operand = columnDeclaration.defaultValue /><#include "_operand.ftl"/>
</#if>