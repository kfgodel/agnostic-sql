<#include "/restrictions/_restrictionMacros.ftl" />
${columnDeclaration.columnName} <#assign type=columnDeclaration.columnType><#include "/columns/_columnType.ftl"/>
<#if columnDeclaration.nullity??>
${columnDeclaration.nullity}
</#if>
<#if columnDeclaration.defaultValue??>
DEFAULT <@expandOperand operand = columnDeclaration.defaultValue />
</#if>