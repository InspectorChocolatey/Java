function Start-Tomcat
{
  $ErrorActionPreference = "Stop";
  $pwd = $(pwd).Path;
  $bin = "C:\Users\InspectorChocolatey\Desktop\Spring MVC\Apache Tomcat\apache-tomcat-8.5.23-windows-x64\apache-tomcat-8.5.23\bin\"
  $success = $true;

  try
  {
    cd $bin
  }
  catch
  {
    $success = $false;
  }
  finally
  {
    if($success)
    {
      .\startup.bat;
      cd $pwd;
    }
    else
    {
      echo "$bin NOT found.";
    }
  }
}


function Get-EnviromentVariables
{
  [Array]$paths = $env:JAVA_HOME,$env:CATALINA_HOME,$env:ANT_HOME;
  foreach($path in $paths)
  {
    Write-Host -Object $path -Fore Green;
  }
}
