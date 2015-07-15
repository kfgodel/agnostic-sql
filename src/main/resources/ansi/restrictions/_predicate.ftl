<#assign operand = predicate.leftSideOperand /><#include "_operand.ftl"/>
${" "}${predicate.operator}${" "}
<#assign operand = predicate.rightSideOperand /><#include "_operand.ftl"/>