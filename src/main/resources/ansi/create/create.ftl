<#include "/macros/_renderAsModel.ftl">
CREATE TABLE <@renderAsModel model=model.table/> (
<#list model.tableParts as tablePart><@compress single_line=true><@renderAsModel model=tablePart/></@compress><#sep>, ${"\n"}</#sep></#list>
)