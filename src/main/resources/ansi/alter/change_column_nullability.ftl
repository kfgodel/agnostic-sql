<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
ALTER TABLE <@renderAsModel model=model.table/> ALTER COLUMN <@renderAsModel model=model.nullabilityChange />
</@compress>