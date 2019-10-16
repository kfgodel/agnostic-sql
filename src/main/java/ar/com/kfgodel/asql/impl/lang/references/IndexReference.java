package ar.com.kfgodel.asql.impl.lang.references;

import ar.com.kfgodel.asql.api.AgnosticConstruct;
import ar.com.kfgodel.asql.impl.model.references.IndexReferenceModel;

/**
 * This type represents the reference to an index
 * Created by tenpines on 27/09/15.
 */
public class IndexReference implements AgnosticConstruct {

  private String name;

  public String getName() {
    return name;
  }

  public static IndexReference create(String indexName) {
    IndexReference reference = new IndexReference();
    reference.name = indexName;
    return reference;
  }

  @Override
  public IndexReferenceModel parseModel() {
    return IndexReferenceModel.create(name);
  }
}
