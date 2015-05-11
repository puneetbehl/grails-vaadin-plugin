import java.util.jar.JarFile

description "Creates minimal required files to run Vaadin application in Grails", "grails vaadin-spring-quickstart"

log "Starting to create quick start files..."
File pluginDir = new File(com.vaadin.grails.VaadinGrailsPlugin.class.getProtectionDomain().getCodeSource().getLocation().getPath());

String s = File.separator
String root = "META-INF${s}templates${s}spring${s}"
String urlMappings = root + "_UrlMappings.template"
String vaadinConfig = root + "_VaadinConfig.template"
String myUi = root + "_MyUI.template"
String itemView = root + "_ItemView.template"

JarFile jarFile = new JarFile(pluginDir)

String vaadinConfigPath = baseDir.absolutePath + "${s}grails-app${s}conf${s}VaadinConfig.groovy"
File vaadinConfigFile = new File(vaadinConfigPath)
vaadinConfigFile.write(jarFile.getInputStream(jarFile.getJarEntry(vaadinConfig)).text)
log "Created: " + vaadinConfigPath

String urlMappingsPath = baseDir.absolutePath + "${s}grails-app${s}controllers${s}UrlMappings.groovy"
File urlMappingsFile = new File(urlMappingsPath)
urlMappingsFile.write(jarFile.getInputStream(jarFile.getJarEntry(urlMappings)).text)
log "Created: " + urlMappingsPath

String comPackage = baseDir.absolutePath + "${s}src${s}main${s}groovy${s}com"
new File(comPackage).mkdir()
log "Created: " + comPackage

String appPackage = baseDir.absolutePath + "${s}src${s}main${s}groovy${s}com${s}app"
new File(appPackage).mkdir()
log "Created: " + appPackage

String myUiPath = appPackage + "${s}MyUI.groovy"
File myUiFile = new File(myUiPath)
myUiFile.write(jarFile.getInputStream(jarFile.getJarEntry(myUi)).text)
log "Created: " + myUiFile.absolutePath

String itemViewPath = appPackage + "${s}ItemView.groovy"
File itemViewFile = new File(itemViewPath)
itemViewFile.write(jarFile.getInputStream(jarFile.getJarEntry(itemView)).text)
log "Created: " + itemViewFile.absolutePath

log "Vaadin Spring QuickStart script finished. You can run: grails run-app"