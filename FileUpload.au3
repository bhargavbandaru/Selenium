Sleep(9000)
If WinGetTitle("File Upload") Then
WinWaitActive("File Upload")
if WinExists("File Upload") Then
ControlSetText("File Upload", "", "Edit1", "C:\Users\Bhargav\Desktop\FileUpload.txt")
Sleep(1000)
ControlClick("File Upload", "", "Button1")
EndIf
Endif

If WinGetTitle("Open") Then
WinWaitActive("Open")
if WinExists("Open") Then
ControlSetText("Open", "", "Edit1", "Edit1", "C:\Users\Bhargav\Desktop\FileUpload.txt")
Sleep(1000)
ControlClick("Open", "", "Button1")
EndIf
Endif

If WinGetTitle("Choose File to Upload") Then
WinWaitActive("Choose File to Upload")
if WinExists("Choose File to Upload") Then
ControlSetText("Choose File to Upload", "", "Edit1", "Edit1", "C:\Users\Bhargav\Desktop\FileUpload.txt")
Sleep(1000)
ControlClick("Choose File to Upload", "", "Button1")
EndIf
Endif