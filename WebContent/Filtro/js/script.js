var macAddress = "";
var ipAddress = "";
var computerName = "";
var wmi = GetObject("winmgmts:{impersonationLevel=impersonate}");
e = new Enumerator(wmi.ExecQuery("SELECT * FROM Win32_NetworkAdapterConfiguration WHERE IPEnabled = True"));
for(; !e.atEnd(); e.moveNext()) {
	var s = e.item();
	macAddress = s.MACAddress;
	ipAddress = s.IPAddress(0);
	computerName = s.DNSHostName;
}