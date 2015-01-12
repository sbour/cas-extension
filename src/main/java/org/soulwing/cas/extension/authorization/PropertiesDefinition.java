/*
 * File created on Dec 15, 2014 
 *
 * Copyright (c) 2015 Carl Harris, Jr.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.soulwing.cas.extension.authorization;

import org.jboss.as.controller.SimpleAttributeDefinition;
import org.jboss.as.controller.SimpleAttributeDefinitionBuilder;
import org.jboss.as.controller.SimpleResourceDefinition;
import org.jboss.as.controller.registry.AttributeAccess;
import org.jboss.as.controller.registry.ManagementResourceRegistration;
import org.jboss.dmr.ModelType;
import org.soulwing.cas.extension.Names;
import org.soulwing.cas.extension.Paths;
import org.soulwing.cas.extension.ResourceUtil;

/**
 * 
 * A definition for the authorization properties resource.
 *
 * @author Carl Harris
 */
public class PropertiesDefinition extends SimpleResourceDefinition {

  static final SimpleAttributeDefinition PATH =
      new SimpleAttributeDefinitionBuilder(Names.PATH, 
          ModelType.STRING)
              .setAllowExpression(true)
              .setAllowNull(true)
              .setXmlName(Names.PATH)
              .setFlags(AttributeAccess.Flag.RESTART_NONE)
              .build();

  static final SimpleAttributeDefinition RELATIVE_TO =
      new SimpleAttributeDefinitionBuilder(Names.RELATIVE_TO, 
          ModelType.STRING)
              .setAllowExpression(true)
              .setAllowNull(true)
              .setXmlName(Names.RELATIVE_TO)
              .setFlags(AttributeAccess.Flag.RESTART_NONE)
              .build();

  public static final PropertiesDefinition INSTANCE =
      new PropertiesDefinition();
  
  private PropertiesDefinition() {
    super(Paths.PROPERTIES, 
        ResourceUtil.getResolver(Names.AUTHORIZATION, Names.PROPERTIES),
        PropertiesAdd.INSTANCE,
        PropertiesRemove.INSTANCE);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void registerAttributes(
      ManagementResourceRegistration resourceRegistration) {
    super.registerAttributes(resourceRegistration);
    resourceRegistration.registerReadWriteAttribute(PATH, 
        null, PropertiesPathHandler.INSTANCE);
    resourceRegistration.registerReadWriteAttribute(RELATIVE_TO, 
        null, PropertiesRelativeToHandler.INSTANCE);
  }
    
}
