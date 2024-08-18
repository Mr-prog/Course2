package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibsInPluginsBlock extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final JakartaLibraryAccessors laccForJakartaLibraryAccessors = new JakartaLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibsInPluginsBlock(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>jakarta</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public JakartaLibraryAccessors getJakarta() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForJakartaLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public OrgLibraryAccessors getOrg() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public BundleAccessors getBundles() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaEjbLibraryAccessors laccForJakartaEjbLibraryAccessors = new JakartaEjbLibraryAccessors(owner);
        private final JakartaEnterpriseLibraryAccessors laccForJakartaEnterpriseLibraryAccessors = new JakartaEnterpriseLibraryAccessors(owner);
        private final JakartaFacesLibraryAccessors laccForJakartaFacesLibraryAccessors = new JakartaFacesLibraryAccessors(owner);
        private final JakartaInjectLibraryAccessors laccForJakartaInjectLibraryAccessors = new JakartaInjectLibraryAccessors(owner);
        private final JakartaPersistenceLibraryAccessors laccForJakartaPersistenceLibraryAccessors = new JakartaPersistenceLibraryAccessors(owner);
        private final JakartaServletLibraryAccessors laccForJakartaServletLibraryAccessors = new JakartaServletLibraryAccessors(owner);

        public JakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.ejb</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaEjbLibraryAccessors getEjb() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaEjbLibraryAccessors;
        }

        /**
         * Group of libraries at <b>jakarta.enterprise</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaEnterpriseLibraryAccessors getEnterprise() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaEnterpriseLibraryAccessors;
        }

        /**
         * Group of libraries at <b>jakarta.faces</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaFacesLibraryAccessors getFaces() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaFacesLibraryAccessors;
        }

        /**
         * Group of libraries at <b>jakarta.inject</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaInjectLibraryAccessors getInject() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaInjectLibraryAccessors;
        }

        /**
         * Group of libraries at <b>jakarta.persistence</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaPersistenceLibraryAccessors getPersistence() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaPersistenceLibraryAccessors;
        }

        /**
         * Group of libraries at <b>jakarta.servlet</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaServletLibraryAccessors getServlet() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaServletLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaEjbLibraryAccessors extends SubDependencyFactory {
        private final JakartaEjbJakartaLibraryAccessors laccForJakartaEjbJakartaLibraryAccessors = new JakartaEjbJakartaLibraryAccessors(owner);

        public JakartaEjbLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.ejb.jakarta</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaEjbJakartaLibraryAccessors getJakarta() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaEjbJakartaLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaEjbJakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaEjbJakartaEjbLibraryAccessors laccForJakartaEjbJakartaEjbLibraryAccessors = new JakartaEjbJakartaEjbLibraryAccessors(owner);

        public JakartaEjbJakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.ejb.jakarta.ejb</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaEjbJakartaEjbLibraryAccessors getEjb() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaEjbJakartaEjbLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaEjbJakartaEjbLibraryAccessors extends SubDependencyFactory {

        public JakartaEjbJakartaEjbLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>jakarta.ejb:jakarta.ejb-api</b> coordinates and
         * with version reference <b>jakarta.ejb.jakarta.ejb.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getApi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("jakarta.ejb.jakarta.ejb.api");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaEnterpriseLibraryAccessors extends SubDependencyFactory {
        private final JakartaEnterpriseJakartaLibraryAccessors laccForJakartaEnterpriseJakartaLibraryAccessors = new JakartaEnterpriseJakartaLibraryAccessors(owner);

        public JakartaEnterpriseLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.enterprise.jakarta</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaEnterpriseJakartaLibraryAccessors getJakarta() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaEnterpriseJakartaLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaEnterpriseJakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaEnterpriseJakartaEnterpriseLibraryAccessors laccForJakartaEnterpriseJakartaEnterpriseLibraryAccessors = new JakartaEnterpriseJakartaEnterpriseLibraryAccessors(owner);

        public JakartaEnterpriseJakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.enterprise.jakarta.enterprise</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaEnterpriseJakartaEnterpriseLibraryAccessors getEnterprise() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaEnterpriseJakartaEnterpriseLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaEnterpriseJakartaEnterpriseLibraryAccessors extends SubDependencyFactory {
        private final JakartaEnterpriseJakartaEnterpriseCdiLibraryAccessors laccForJakartaEnterpriseJakartaEnterpriseCdiLibraryAccessors = new JakartaEnterpriseJakartaEnterpriseCdiLibraryAccessors(owner);

        public JakartaEnterpriseJakartaEnterpriseLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.enterprise.jakarta.enterprise.cdi</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaEnterpriseJakartaEnterpriseCdiLibraryAccessors getCdi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaEnterpriseJakartaEnterpriseCdiLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaEnterpriseJakartaEnterpriseCdiLibraryAccessors extends SubDependencyFactory {

        public JakartaEnterpriseJakartaEnterpriseCdiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>jakarta.enterprise:jakarta.enterprise.cdi-api</b> coordinates and
         * with version reference <b>jakarta.enterprise.jakarta.enterprise.cdi.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getApi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("jakarta.enterprise.jakarta.enterprise.cdi.api");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaFacesLibraryAccessors extends SubDependencyFactory {
        private final JakartaFacesJakartaLibraryAccessors laccForJakartaFacesJakartaLibraryAccessors = new JakartaFacesJakartaLibraryAccessors(owner);

        public JakartaFacesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.faces.jakarta</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaFacesJakartaLibraryAccessors getJakarta() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaFacesJakartaLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaFacesJakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaFacesJakartaFacesLibraryAccessors laccForJakartaFacesJakartaFacesLibraryAccessors = new JakartaFacesJakartaFacesLibraryAccessors(owner);

        public JakartaFacesJakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.faces.jakarta.faces</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaFacesJakartaFacesLibraryAccessors getFaces() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaFacesJakartaFacesLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaFacesJakartaFacesLibraryAccessors extends SubDependencyFactory {

        public JakartaFacesJakartaFacesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>jakarta.faces:jakarta.faces-api</b> coordinates and
         * with version reference <b>jakarta.faces.jakarta.faces.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getApi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("jakarta.faces.jakarta.faces.api");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaInjectLibraryAccessors extends SubDependencyFactory {
        private final JakartaInjectJakartaLibraryAccessors laccForJakartaInjectJakartaLibraryAccessors = new JakartaInjectJakartaLibraryAccessors(owner);

        public JakartaInjectLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.inject.jakarta</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaInjectJakartaLibraryAccessors getJakarta() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaInjectJakartaLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaInjectJakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaInjectJakartaInjectLibraryAccessors laccForJakartaInjectJakartaInjectLibraryAccessors = new JakartaInjectJakartaInjectLibraryAccessors(owner);

        public JakartaInjectJakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.inject.jakarta.inject</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaInjectJakartaInjectLibraryAccessors getInject() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaInjectJakartaInjectLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaInjectJakartaInjectLibraryAccessors extends SubDependencyFactory {

        public JakartaInjectJakartaInjectLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>jakarta.inject:jakarta.inject-api</b> coordinates and
         * with version reference <b>jakarta.inject.jakarta.inject.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getApi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("jakarta.inject.jakarta.inject.api");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaPersistenceLibraryAccessors extends SubDependencyFactory {
        private final JakartaPersistenceJakartaLibraryAccessors laccForJakartaPersistenceJakartaLibraryAccessors = new JakartaPersistenceJakartaLibraryAccessors(owner);

        public JakartaPersistenceLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.persistence.jakarta</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaPersistenceJakartaLibraryAccessors getJakarta() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaPersistenceJakartaLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaPersistenceJakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaPersistenceJakartaPersistenceLibraryAccessors laccForJakartaPersistenceJakartaPersistenceLibraryAccessors = new JakartaPersistenceJakartaPersistenceLibraryAccessors(owner);

        public JakartaPersistenceJakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.persistence.jakarta.persistence</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaPersistenceJakartaPersistenceLibraryAccessors getPersistence() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaPersistenceJakartaPersistenceLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaPersistenceJakartaPersistenceLibraryAccessors extends SubDependencyFactory {

        public JakartaPersistenceJakartaPersistenceLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>jakarta.persistence:jakarta.persistence-api</b> coordinates and
         * with version reference <b>jakarta.persistence.jakarta.persistence.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getApi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("jakarta.persistence.jakarta.persistence.api");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaServletLibraryAccessors extends SubDependencyFactory {
        private final JakartaServletJakartaLibraryAccessors laccForJakartaServletJakartaLibraryAccessors = new JakartaServletJakartaLibraryAccessors(owner);

        public JakartaServletLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.servlet.jakarta</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaServletJakartaLibraryAccessors getJakarta() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaServletJakartaLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaServletJakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaServletJakartaServletLibraryAccessors laccForJakartaServletJakartaServletLibraryAccessors = new JakartaServletJakartaServletLibraryAccessors(owner);

        public JakartaServletJakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.servlet.jakarta.servlet</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaServletJakartaServletLibraryAccessors getServlet() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaServletJakartaServletLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaServletJakartaServletLibraryAccessors extends SubDependencyFactory {

        public JakartaServletJakartaServletLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>jakarta.servlet:jakarta.servlet-api</b> coordinates and
         * with version reference <b>jakarta.servlet.jakarta.servlet.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getApi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("jakarta.servlet.jakarta.servlet.api");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgHibernateLibraryAccessors laccForOrgHibernateLibraryAccessors = new OrgHibernateLibraryAccessors(owner);
        private final OrgPostgresqlLibraryAccessors laccForOrgPostgresqlLibraryAccessors = new OrgPostgresqlLibraryAccessors(owner);
        private final OrgProjectlombokLibraryAccessors laccForOrgProjectlombokLibraryAccessors = new OrgProjectlombokLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.hibernate</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgHibernateLibraryAccessors getHibernate() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgHibernateLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.postgresql</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgPostgresqlLibraryAccessors getPostgresql() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgPostgresqlLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.projectlombok</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgProjectlombokLibraryAccessors getProjectlombok() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgProjectlombokLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgHibernateLibraryAccessors extends SubDependencyFactory {
        private final OrgHibernateOrmLibraryAccessors laccForOrgHibernateOrmLibraryAccessors = new OrgHibernateOrmLibraryAccessors(owner);

        public OrgHibernateLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.hibernate.orm</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgHibernateOrmLibraryAccessors getOrm() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgHibernateOrmLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgHibernateOrmLibraryAccessors extends SubDependencyFactory {
        private final OrgHibernateOrmHibernateLibraryAccessors laccForOrgHibernateOrmHibernateLibraryAccessors = new OrgHibernateOrmHibernateLibraryAccessors(owner);

        public OrgHibernateOrmLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.hibernate.orm.hibernate</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgHibernateOrmHibernateLibraryAccessors getHibernate() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgHibernateOrmHibernateLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgHibernateOrmHibernateLibraryAccessors extends SubDependencyFactory {

        public OrgHibernateOrmHibernateLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.hibernate.orm:hibernate-core</b> coordinates and
         * with version reference <b>org.hibernate.orm.hibernate.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCore() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.hibernate.orm.hibernate.core");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgPostgresqlLibraryAccessors extends SubDependencyFactory {

        public OrgPostgresqlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>postgresql</b> with <b>org.postgresql:postgresql</b> coordinates and
         * with version reference <b>org.postgresql.postgresql</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getPostgresql() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.postgresql.postgresql");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgProjectlombokLibraryAccessors extends SubDependencyFactory {

        public OrgProjectlombokLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>lombok</b> with <b>org.projectlombok:lombok</b> coordinates and
         * with version reference <b>org.projectlombok.lombok</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getLombok() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.projectlombok.lombok");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final JakartaVersionAccessors vaccForJakartaVersionAccessors = new JakartaVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta</b>
         */
        public JakartaVersionAccessors getJakarta() {
            return vaccForJakartaVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class JakartaVersionAccessors extends VersionFactory  {

        private final JakartaEjbVersionAccessors vaccForJakartaEjbVersionAccessors = new JakartaEjbVersionAccessors(providers, config);
        private final JakartaEnterpriseVersionAccessors vaccForJakartaEnterpriseVersionAccessors = new JakartaEnterpriseVersionAccessors(providers, config);
        private final JakartaFacesVersionAccessors vaccForJakartaFacesVersionAccessors = new JakartaFacesVersionAccessors(providers, config);
        private final JakartaInjectVersionAccessors vaccForJakartaInjectVersionAccessors = new JakartaInjectVersionAccessors(providers, config);
        private final JakartaPersistenceVersionAccessors vaccForJakartaPersistenceVersionAccessors = new JakartaPersistenceVersionAccessors(providers, config);
        private final JakartaServletVersionAccessors vaccForJakartaServletVersionAccessors = new JakartaServletVersionAccessors(providers, config);
        public JakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.ejb</b>
         */
        public JakartaEjbVersionAccessors getEjb() {
            return vaccForJakartaEjbVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.jakarta.enterprise</b>
         */
        public JakartaEnterpriseVersionAccessors getEnterprise() {
            return vaccForJakartaEnterpriseVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.jakarta.faces</b>
         */
        public JakartaFacesVersionAccessors getFaces() {
            return vaccForJakartaFacesVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.jakarta.inject</b>
         */
        public JakartaInjectVersionAccessors getInject() {
            return vaccForJakartaInjectVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.jakarta.persistence</b>
         */
        public JakartaPersistenceVersionAccessors getPersistence() {
            return vaccForJakartaPersistenceVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.jakarta.servlet</b>
         */
        public JakartaServletVersionAccessors getServlet() {
            return vaccForJakartaServletVersionAccessors;
        }

    }

    public static class JakartaEjbVersionAccessors extends VersionFactory  {

        private final JakartaEjbJakartaVersionAccessors vaccForJakartaEjbJakartaVersionAccessors = new JakartaEjbJakartaVersionAccessors(providers, config);
        public JakartaEjbVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.ejb.jakarta</b>
         */
        public JakartaEjbJakartaVersionAccessors getJakarta() {
            return vaccForJakartaEjbJakartaVersionAccessors;
        }

    }

    public static class JakartaEjbJakartaVersionAccessors extends VersionFactory  {

        private final JakartaEjbJakartaEjbVersionAccessors vaccForJakartaEjbJakartaEjbVersionAccessors = new JakartaEjbJakartaEjbVersionAccessors(providers, config);
        public JakartaEjbJakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.ejb.jakarta.ejb</b>
         */
        public JakartaEjbJakartaEjbVersionAccessors getEjb() {
            return vaccForJakartaEjbJakartaEjbVersionAccessors;
        }

    }

    public static class JakartaEjbJakartaEjbVersionAccessors extends VersionFactory  {

        public JakartaEjbJakartaEjbVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>jakarta.ejb.jakarta.ejb.api</b> with value <b>4.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("jakarta.ejb.jakarta.ejb.api"); }

    }

    public static class JakartaEnterpriseVersionAccessors extends VersionFactory  {

        private final JakartaEnterpriseJakartaVersionAccessors vaccForJakartaEnterpriseJakartaVersionAccessors = new JakartaEnterpriseJakartaVersionAccessors(providers, config);
        public JakartaEnterpriseVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.enterprise.jakarta</b>
         */
        public JakartaEnterpriseJakartaVersionAccessors getJakarta() {
            return vaccForJakartaEnterpriseJakartaVersionAccessors;
        }

    }

    public static class JakartaEnterpriseJakartaVersionAccessors extends VersionFactory  {

        private final JakartaEnterpriseJakartaEnterpriseVersionAccessors vaccForJakartaEnterpriseJakartaEnterpriseVersionAccessors = new JakartaEnterpriseJakartaEnterpriseVersionAccessors(providers, config);
        public JakartaEnterpriseJakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.enterprise.jakarta.enterprise</b>
         */
        public JakartaEnterpriseJakartaEnterpriseVersionAccessors getEnterprise() {
            return vaccForJakartaEnterpriseJakartaEnterpriseVersionAccessors;
        }

    }

    public static class JakartaEnterpriseJakartaEnterpriseVersionAccessors extends VersionFactory  {

        private final JakartaEnterpriseJakartaEnterpriseCdiVersionAccessors vaccForJakartaEnterpriseJakartaEnterpriseCdiVersionAccessors = new JakartaEnterpriseJakartaEnterpriseCdiVersionAccessors(providers, config);
        public JakartaEnterpriseJakartaEnterpriseVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.enterprise.jakarta.enterprise.cdi</b>
         */
        public JakartaEnterpriseJakartaEnterpriseCdiVersionAccessors getCdi() {
            return vaccForJakartaEnterpriseJakartaEnterpriseCdiVersionAccessors;
        }

    }

    public static class JakartaEnterpriseJakartaEnterpriseCdiVersionAccessors extends VersionFactory  {

        public JakartaEnterpriseJakartaEnterpriseCdiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>jakarta.enterprise.jakarta.enterprise.cdi.api</b> with value <b>3.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("jakarta.enterprise.jakarta.enterprise.cdi.api"); }

    }

    public static class JakartaFacesVersionAccessors extends VersionFactory  {

        private final JakartaFacesJakartaVersionAccessors vaccForJakartaFacesJakartaVersionAccessors = new JakartaFacesJakartaVersionAccessors(providers, config);
        public JakartaFacesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.faces.jakarta</b>
         */
        public JakartaFacesJakartaVersionAccessors getJakarta() {
            return vaccForJakartaFacesJakartaVersionAccessors;
        }

    }

    public static class JakartaFacesJakartaVersionAccessors extends VersionFactory  {

        private final JakartaFacesJakartaFacesVersionAccessors vaccForJakartaFacesJakartaFacesVersionAccessors = new JakartaFacesJakartaFacesVersionAccessors(providers, config);
        public JakartaFacesJakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.faces.jakarta.faces</b>
         */
        public JakartaFacesJakartaFacesVersionAccessors getFaces() {
            return vaccForJakartaFacesJakartaFacesVersionAccessors;
        }

    }

    public static class JakartaFacesJakartaFacesVersionAccessors extends VersionFactory  {

        public JakartaFacesJakartaFacesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>jakarta.faces.jakarta.faces.api</b> with value <b>3.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("jakarta.faces.jakarta.faces.api"); }

    }

    public static class JakartaInjectVersionAccessors extends VersionFactory  {

        private final JakartaInjectJakartaVersionAccessors vaccForJakartaInjectJakartaVersionAccessors = new JakartaInjectJakartaVersionAccessors(providers, config);
        public JakartaInjectVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.inject.jakarta</b>
         */
        public JakartaInjectJakartaVersionAccessors getJakarta() {
            return vaccForJakartaInjectJakartaVersionAccessors;
        }

    }

    public static class JakartaInjectJakartaVersionAccessors extends VersionFactory  {

        private final JakartaInjectJakartaInjectVersionAccessors vaccForJakartaInjectJakartaInjectVersionAccessors = new JakartaInjectJakartaInjectVersionAccessors(providers, config);
        public JakartaInjectJakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.inject.jakarta.inject</b>
         */
        public JakartaInjectJakartaInjectVersionAccessors getInject() {
            return vaccForJakartaInjectJakartaInjectVersionAccessors;
        }

    }

    public static class JakartaInjectJakartaInjectVersionAccessors extends VersionFactory  {

        public JakartaInjectJakartaInjectVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>jakarta.inject.jakarta.inject.api</b> with value <b>2.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("jakarta.inject.jakarta.inject.api"); }

    }

    public static class JakartaPersistenceVersionAccessors extends VersionFactory  {

        private final JakartaPersistenceJakartaVersionAccessors vaccForJakartaPersistenceJakartaVersionAccessors = new JakartaPersistenceJakartaVersionAccessors(providers, config);
        public JakartaPersistenceVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.persistence.jakarta</b>
         */
        public JakartaPersistenceJakartaVersionAccessors getJakarta() {
            return vaccForJakartaPersistenceJakartaVersionAccessors;
        }

    }

    public static class JakartaPersistenceJakartaVersionAccessors extends VersionFactory  {

        private final JakartaPersistenceJakartaPersistenceVersionAccessors vaccForJakartaPersistenceJakartaPersistenceVersionAccessors = new JakartaPersistenceJakartaPersistenceVersionAccessors(providers, config);
        public JakartaPersistenceJakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.persistence.jakarta.persistence</b>
         */
        public JakartaPersistenceJakartaPersistenceVersionAccessors getPersistence() {
            return vaccForJakartaPersistenceJakartaPersistenceVersionAccessors;
        }

    }

    public static class JakartaPersistenceJakartaPersistenceVersionAccessors extends VersionFactory  {

        public JakartaPersistenceJakartaPersistenceVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>jakarta.persistence.jakarta.persistence.api</b> with value <b>3.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("jakarta.persistence.jakarta.persistence.api"); }

    }

    public static class JakartaServletVersionAccessors extends VersionFactory  {

        private final JakartaServletJakartaVersionAccessors vaccForJakartaServletJakartaVersionAccessors = new JakartaServletJakartaVersionAccessors(providers, config);
        public JakartaServletVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.servlet.jakarta</b>
         */
        public JakartaServletJakartaVersionAccessors getJakarta() {
            return vaccForJakartaServletJakartaVersionAccessors;
        }

    }

    public static class JakartaServletJakartaVersionAccessors extends VersionFactory  {

        private final JakartaServletJakartaServletVersionAccessors vaccForJakartaServletJakartaServletVersionAccessors = new JakartaServletJakartaServletVersionAccessors(providers, config);
        public JakartaServletJakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.servlet.jakarta.servlet</b>
         */
        public JakartaServletJakartaServletVersionAccessors getServlet() {
            return vaccForJakartaServletJakartaServletVersionAccessors;
        }

    }

    public static class JakartaServletJakartaServletVersionAccessors extends VersionFactory  {

        public JakartaServletJakartaServletVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>jakarta.servlet.jakarta.servlet.api</b> with value <b>5.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("jakarta.servlet.jakarta.servlet.api"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgHibernateVersionAccessors vaccForOrgHibernateVersionAccessors = new OrgHibernateVersionAccessors(providers, config);
        private final OrgPostgresqlVersionAccessors vaccForOrgPostgresqlVersionAccessors = new OrgPostgresqlVersionAccessors(providers, config);
        private final OrgProjectlombokVersionAccessors vaccForOrgProjectlombokVersionAccessors = new OrgProjectlombokVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.hibernate</b>
         */
        public OrgHibernateVersionAccessors getHibernate() {
            return vaccForOrgHibernateVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.postgresql</b>
         */
        public OrgPostgresqlVersionAccessors getPostgresql() {
            return vaccForOrgPostgresqlVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.projectlombok</b>
         */
        public OrgProjectlombokVersionAccessors getProjectlombok() {
            return vaccForOrgProjectlombokVersionAccessors;
        }

    }

    public static class OrgHibernateVersionAccessors extends VersionFactory  {

        private final OrgHibernateOrmVersionAccessors vaccForOrgHibernateOrmVersionAccessors = new OrgHibernateOrmVersionAccessors(providers, config);
        public OrgHibernateVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.hibernate.orm</b>
         */
        public OrgHibernateOrmVersionAccessors getOrm() {
            return vaccForOrgHibernateOrmVersionAccessors;
        }

    }

    public static class OrgHibernateOrmVersionAccessors extends VersionFactory  {

        private final OrgHibernateOrmHibernateVersionAccessors vaccForOrgHibernateOrmHibernateVersionAccessors = new OrgHibernateOrmHibernateVersionAccessors(providers, config);
        public OrgHibernateOrmVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.hibernate.orm.hibernate</b>
         */
        public OrgHibernateOrmHibernateVersionAccessors getHibernate() {
            return vaccForOrgHibernateOrmHibernateVersionAccessors;
        }

    }

    public static class OrgHibernateOrmHibernateVersionAccessors extends VersionFactory  {

        public OrgHibernateOrmHibernateVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.hibernate.orm.hibernate.core</b> with value <b>6.2.7.Final</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.hibernate.orm.hibernate.core"); }

    }

    public static class OrgPostgresqlVersionAccessors extends VersionFactory  {

        public OrgPostgresqlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.postgresql.postgresql</b> with value <b>42.6.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPostgresql() { return getVersion("org.postgresql.postgresql"); }

    }

    public static class OrgProjectlombokVersionAccessors extends VersionFactory  {

        public OrgProjectlombokVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.projectlombok.lombok</b> with value <b>1.18.28</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLombok() { return getVersion("org.projectlombok.lombok"); }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
