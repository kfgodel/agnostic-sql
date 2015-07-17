<#macro expandOperand operand>
<#if operand.subquery>
subquery
<#elseif operand.function>
  <#include "/functions/${operand.agnosticName}.ftl"/>
<#elseif operand.predicate>
  <@expandPredicate predicate=operand />
<#elseif operand.string>
'${operand.value}'
<#else>
${operand.value}
</#if>
</#macro>

<#macro expandPredicate predicate>
<@expandOperand operand = predicate.leftSideOperand/>
${" "}${predicate.operator}${" "}
<@expandOperand operand = predicate.rightSideOperand/>
</#macro>

