function New-JavaProject
{

Param(
[ValidateNotNullOrEmpty()]
[Parameter(Mandatory=$true)]
[String]$ProjectName
)

$ErrorActionPreference = "Stop";
$VerbosePreference = "Continue";

$CLASS_HOME = "C:\javaclasses\com\nicholasjacquet";
$main = "$CLASS_HOME\$ProjectName\src\main";
$test = "$CLASS_HOME\$ProjectName\src\test" ;

	foreach( $directory in $CLASS_HOME,$main,$test)
	{
		if(!(Test-Path -Path $directory))
		{
			New-Item -Path $directory -ItemType Directory -Verbose | Out-Null;
		}
	}

	foreach( $directory in $main,$test)
	{
		foreach($child in "java","resources")
		{
			$obj = $(Join-Path -Path $directory -ChildPath $child);

			if(!(Test-Path -Path $obj))
			{
				New-Item -Path $obj -ItemType Directory -Verbose | Out-Null;
			}
		}
	}
}
