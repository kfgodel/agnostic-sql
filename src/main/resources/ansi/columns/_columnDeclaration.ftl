${columnDeclaration.columnName} <#assign type=columnDeclaration.columnType><#include "/columns/_columnType.ftl"/>
<#if columnDeclaration.nullity??>
${columnDeclaration.nullity}
</#if>
<#if columnDeclaration.defaultValue??>
DEFAULT <#assign operand = columnDeclaration.defaultValue /><#include "/restrictions/_operand.ftl"/>
</#if>