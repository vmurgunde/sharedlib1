 def call(tomcatIP,warName,credID){
 sshagent(["${credID}"]) {
         //copy war file to tomcat server
         sh "scp -o StrictHostKeyChecking=no target/*.war ec2-user@${tomcatIP}:/opt/tomcat8/webapps/${warName}.war"
         // stop tomcat
         sh "ssh ec2-user@${tomcatIP} /opt/tomcat8/bin/shutdown.sh"
         // start tomcat
         sh "ssh ec2-user@${tomcatIP} /opt/tomcat8/bin/startup.sh"
        }

 }
