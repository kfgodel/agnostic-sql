<#if operand.subquery>
subquery
<#elseif operand.function>
<#include "/functions/${operand.agnosticName}.ftl"/>
<#elseif operand.string>
'${operand.value}'
<#else>
${operand.value}
</#if>