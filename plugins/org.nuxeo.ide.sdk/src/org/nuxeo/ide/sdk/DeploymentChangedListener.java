package org.nuxeo.ide.sdk;

import org.nuxeo.ide.sdk.deploy.Deployment;

public interface DeploymentChangedListener {
    
    void deploymentChanged(NuxeoSDK sdk, Deployment deployment);

}
