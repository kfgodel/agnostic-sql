<@compress single_line=true>
INSERT INTO ${tableName} (
<#list columnAssignments as columnAssignment>
${columnAssignment.columnName}<#sep>, </#sep>
</#list>
) VALUES (
<#list columnAssignments as columnAssignment>
<#assign operand = columnAssignment.assignedValue /><#include "/restrictions/_operand.ftl"/><#sep>, </#sep>
</#list>
)
</@compress>