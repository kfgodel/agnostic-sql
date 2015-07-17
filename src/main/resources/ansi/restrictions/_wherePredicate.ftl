<#if wherePredicate??>
<#assign predicate=wherePredicate />${" "}WHERE <#include "/restrictions/_predicate.ftl">
</#if>