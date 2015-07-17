<#include "_restrictionMacros.ftl"/>
<#if wherePredicate??>
${" "}WHERE <@expandPredicate predicate=wherePredicate />
</#if>