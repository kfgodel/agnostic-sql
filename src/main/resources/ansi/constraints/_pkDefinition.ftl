<#include "/macros/_renderAsModel.ftl" />
PRIMARY KEY (
<#list model.columns as column>
  <@renderAsModel model=column/><#sep>, </#sep>
</#list>
)