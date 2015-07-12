<@compress single_line=true>
UPDATE ${tableName}
SET <#list columnAssignments as columnAssignment>
  <#include "_columnAssignment.ftl"><#sep>,
</#list>
<#if conditioned>
${" "}WHERE <#include "_predicate.ftl">
</#if>
</@compress>