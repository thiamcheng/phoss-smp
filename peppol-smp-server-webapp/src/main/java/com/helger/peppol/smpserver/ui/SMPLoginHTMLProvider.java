/**
 * Copyright (C) 2014-2018 Philip Helger and contributors
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.peppol.smpserver.ui;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.html.hc.IHCNode;
import com.helger.html.hc.html.grouping.HCDiv;
import com.helger.html.hc.html.textlevel.HCSmall;
import com.helger.html.hc.impl.HCNodeList;
import com.helger.peppol.smpserver.app.CSMP;
import com.helger.peppol.smpserver.ui.pub.SMPRendererPublic;
import com.helger.photon.bootstrap4.CBootstrapCSS;
import com.helger.photon.bootstrap4.uictrls.ext.BootstrapLoginHTMLProvider;
import com.helger.photon.bootstrap4.utils.BootstrapPageHeader;
import com.helger.photon.core.app.context.ISimpleWebExecutionContext;
import com.helger.security.authentication.credentials.ICredentialValidationResult;

/**
 * The login screen HTML provider.
 *
 * @author Philip Helger
 */
public final class SMPLoginHTMLProvider extends BootstrapLoginHTMLProvider
{
  public SMPLoginHTMLProvider (final boolean bLoginError,
                               @Nonnull final ICredentialValidationResult aLoginResult,
                               @Nullable final IHCNode aPageTitle)
  {
    super (bLoginError, aLoginResult, aPageTitle);
  }

  @Override
  @Nonnull
  protected IHCNode createPageHeader (@Nonnull final ISimpleWebExecutionContext aSWEC,
                                      @Nullable final IHCNode aPageTitle)
  {
    final HCNodeList ret = new HCNodeList ();
    ret.addChild (new HCDiv ().addClass (CBootstrapCSS.MB_3).addChild (SMPRendererPublic.createLogoBig (aSWEC)));
    ret.addChild (new BootstrapPageHeader ().addChild ("Administration - Login"));
    return ret;
  }

  @Override
  @Nullable
  protected IHCNode createFormFooter (@Nonnull final ISimpleWebExecutionContext aSWEC)
  {
    final HCDiv aDiv = new HCDiv ().addClass (CBootstrapCSS.D_FLEX).addClass (CBootstrapCSS.MT_3);
    aDiv.addChild (new HCSmall ().addChild (CSMP.getApplicationTitleAndVersion ()));
    return aDiv;
  }
}
