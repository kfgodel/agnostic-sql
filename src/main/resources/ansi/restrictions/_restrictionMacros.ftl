<#macro renderOperand operand>
<#if operand.subquery>
subquery
<#elseif operand.function>
  <#include "/functions/${operand.agnosticName}.ftl"/>
<#elseif operand.predicate>
  <@renderPredicate predicate=operand />
<#elseif operand.string>
'${operand.value}'
<#else>
${operand.value}
</#if>
</#macro>
<#macro renderPredicate predicate>
<@renderOperand operand = predicate.leftSideOperand/>
${" "}${predicate.operator}${" "}
<@renderOperand operand = predicate.rightSideOperand/>
</#macro>

