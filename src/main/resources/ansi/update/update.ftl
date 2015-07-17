<@compress single_line=true>
UPDATE ${tableName}
SET <#list columnAssignments as columnAssignment>
  <#include "/columns/_columnAssignment.ftl">
  <#sep>, </#sep>
</#list>
<#include "/restrictions/_wherePredicate.ftl" />
</@compress>