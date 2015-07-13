<#if operand.subquery>
subquery
<#elseif operand.string>
'${operand.value}'
<#else>
${operand.value}
</#if>