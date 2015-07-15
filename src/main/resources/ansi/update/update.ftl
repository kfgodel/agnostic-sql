<@compress single_line=true>
UPDATE ${tableName}
SET <#list columnAssignments as columnAssignment>
  <#include "/columns/_columnAssignment.ftl">
  <#sep>, </#sep>
</#list>
<#if wherePredicate??>
<#assign predicate=wherePredicate />
${" "}WHERE <#include "/restrictions/_predicate.ftl">
</#if>
</@compress>