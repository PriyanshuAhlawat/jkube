/**
 * Copyright (c) 2019 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at:
 *
 *     https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package io.jkube.maven.enricher.handler;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceStatus;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.jkube.kit.common.util.KubernetesHelper;

public class NamespaceHandler {

    public Namespace getNamespace(String ns) {
        Namespace namespace = new Namespace();
        namespace.setMetadata(createProjectMetaData(ns));
        namespace.setStatus(new NamespaceStatus("active"));
        return namespace;
    }

    private ObjectMeta createProjectMetaData(String namespace) {
        return new ObjectMetaBuilder()
                .withName(KubernetesHelper.validateKubernetesId(namespace, "namespace name"))
                .build();
    }

}