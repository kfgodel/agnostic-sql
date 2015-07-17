<@compress single_line=true>
<#include "/restrictions/_restrictionMacros.ftl" />
INSERT INTO ${tableName} (
<#list columnAssignments as columnAssignment>
${columnAssignment.columnName}<#sep>, </#sep>
</#list>
) VALUES (
<#list columnAssignments as columnAssignment>
<@expandOperand operand = columnAssignment.assignedValue /><#sep>, </#sep>
</#list>
)
</@compress>