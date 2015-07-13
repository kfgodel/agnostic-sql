<@compress single_line=true>
${columnDeclaration.columnName} ${columnDeclaration.columnType}
<#if columnDeclaration.nullity??>
${columnDeclaration.nullity}
</#if>
<#if columnDeclaration.defaultValue??>
DEFAULT <#assign operand = columnDeclaration.defaultValue /><#include "_operand.ftl"/>
</#if>
</@compress>