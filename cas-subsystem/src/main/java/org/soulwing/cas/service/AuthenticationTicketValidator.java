/*
 * File created on Jan 23, 2015 
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
package org.soulwing.cas.service;

import org.soulwing.cas.api.IdentityAssertion;

/**
 * A service object that validates CAS authentication tickets.
 *
 * @author Carl Harris
 */
public interface AuthenticationTicketValidator {

  /**
   * Validates a CAS authentication ticket for a given service.
   * @param ticket the subject ticket
   * @param service the target service
   * @return identity assertion describing the authentic ticket holder
   * @throws AuthenticationException if the ticket cannot be validated
   */
  IdentityAssertion validate(String ticket, String service)
      throws AuthenticationException;
  
}