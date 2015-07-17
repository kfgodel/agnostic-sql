<#include "_restrictionMacros.ftl"/>
<#if wherePredicate??>
${" "}WHERE <@renderPredicate predicate=wherePredicate />
</#if>