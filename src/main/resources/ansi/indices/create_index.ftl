<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
CREATE INDEX <@renderAsModel model=model.index/>
ON <@renderAsModel model=model.table/>
(<#list model.columns as column><@renderAsModel model=column/><#sep>, </#sep></#list>)
</@compress>