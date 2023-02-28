#include <iostream>
#include <Windows.h>
#include <ntstatus.h>
#pragma comment(lib, "ntdll.lib")
#define SHUTDOWN_PRIVILEGE 19
#define OPTION_SHUTDOWN 6

EXTERN_C NTSTATUS NTAPI RtlAdjustPrivilege(
    ULONG,
    BOOLEAN,
    BOOLEAN,
    PBOOLEAN);
EXTERN_C NTSTATUS NTAPI NtRaiseHardError(
    NTSTATUS,
    ULONG,
    PULONG_PTR,
    ULONG,
    ULONG,
    PULONG
);

void main()
{
    BOOLEAN Enabled;
    RtlAdjustPrivilege(SHUTDOWN_PRIVILEGE, TRUE, FALSE, &Enabled);
    if (Enabled == 0) {
        ULONG response;
        NtRaiseHardError(0xDEADDEADL, 0, 0, 0, OPTION_SHUTDOWN, &response);
    }
}
