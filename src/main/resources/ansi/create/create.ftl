<#include "/macros/_renderAsModel.ftl">
CREATE TABLE ${tableName} (
<#list tableParts as tablePart><@compress single_line=true><@renderAsModel model=tablePart/></@compress><#sep>, ${"\n"}</#sep></#list>
)