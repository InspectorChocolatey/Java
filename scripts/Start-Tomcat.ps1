function Start-Tomcat
{

$ErrorActionPreference = "Stop";
$VerbosePreference = "Continue";

$tomcat = "C:\tomcat\apache-tomcat-8.5.23"
$bin = Join-Path -Path $tomcat -ChildPath "bin"

    if(Test-Path -Path $bin)
    {
        Write-Verbose -Message "Starting Tomcat server";
        Start-Process -FilePath "startup.bat" -WorkingDirectory "$bin"
    }
    else
    {
        Write-Verbose -Message "Bin directory: $bin NOT FOUND";
        break;
    }
}
