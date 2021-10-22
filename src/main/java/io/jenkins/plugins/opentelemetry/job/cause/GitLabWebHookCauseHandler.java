/*
 * Copyright The Original Author or Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.jenkins.plugins.opentelemetry.job.cause;

import hudson.Extension;
import hudson.model.Cause;
import jenkins.YesNoMaybe;

import javax.annotation.Nonnull;

@Extension(optional = true, dynamicLoadable = YesNoMaybe.YES)
public class GitLabWebHookCauseHandler extends AbstractCauseHandler {

    @Override
    public boolean isSupported(@Nonnull Cause cause) {
        return isGitLabWebHookCause(cause);
    }

    @Override
    public String getDetails(@Nonnull Cause cause)  {
        // https://github.com/jenkinsci/gitlab-plugin/blob/master/src/main/resources/com/dabsquared/gitlabjenkins/cause/Messages.properties#L2
        String id = cause.getShortDescription().replaceAll(".* by ", "");
        return ":" + id;
    }
}