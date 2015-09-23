<#include "/macros/_renderAsModel.ftl" />
UNIQUE (
<#list model.columns as column>
  <@renderAsModel model=column/><#sep>, </#sep>
</#list>
)