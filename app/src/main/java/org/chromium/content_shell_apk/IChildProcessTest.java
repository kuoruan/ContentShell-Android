/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: ../../content/shell/android/shell_apk/src/org/chromium/content_shell_apk/IChildProcessTest.aidl
 */
package org.chromium.content_shell_apk;
/**
  * Interface provided to the TestChildProcessService. Used to echo back the calls made on the
  * ChildProcessServiceDelegate to the test process.
  */
public interface IChildProcessTest extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements org.chromium.content_shell_apk.IChildProcessTest
{
private static final java.lang.String DESCRIPTOR = "org.chromium.content_shell_apk.IChildProcessTest";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an org.chromium.content_shell_apk.IChildProcessTest interface,
 * generating a proxy if needed.
 */
public static org.chromium.content_shell_apk.IChildProcessTest asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof org.chromium.content_shell_apk.IChildProcessTest))) {
return ((org.chromium.content_shell_apk.IChildProcessTest)iin);
}
return new org.chromium.content_shell_apk.IChildProcessTest.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onConnectionSetup:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
android.os.Bundle _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
android.os.Bundle _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.onConnectionSetup(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_onLoadNativeLibrary:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.onLoadNativeLibrary(_arg0);
return true;
}
case TRANSACTION_onBeforeMain:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
this.onBeforeMain(_arg0);
return true;
}
case TRANSACTION_onRunMain:
{
data.enforceInterface(DESCRIPTOR);
this.onRunMain();
return true;
}
case TRANSACTION_onDestroy:
{
data.enforceInterface(DESCRIPTOR);
this.onDestroy();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements org.chromium.content_shell_apk.IChildProcessTest
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
// Called by the service when onConnectionSetup is received. Echos back the parameters received
// so far.

@Override public void onConnectionSetup(boolean serviceCreatedCalled, android.os.Bundle serviceBundle, android.os.Bundle connectionBundle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((serviceCreatedCalled)?(1):(0)));
if ((serviceBundle!=null)) {
_data.writeInt(1);
serviceBundle.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((connectionBundle!=null)) {
_data.writeInt(1);
connectionBundle.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onConnectionSetup, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onLoadNativeLibrary(boolean loadedSuccessfully) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((loadedSuccessfully)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onLoadNativeLibrary, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onBeforeMain(java.lang.String[] commandLine) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(commandLine);
mRemote.transact(Stub.TRANSACTION_onBeforeMain, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onRunMain() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onRunMain, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onDestroy() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onDestroy, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onConnectionSetup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onLoadNativeLibrary = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onBeforeMain = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_onRunMain = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_onDestroy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
}
// Called by the service when onConnectionSetup is received. Echos back the parameters received
// so far.

public void onConnectionSetup(boolean serviceCreatedCalled, android.os.Bundle serviceBundle, android.os.Bundle connectionBundle) throws android.os.RemoteException;
public void onLoadNativeLibrary(boolean loadedSuccessfully) throws android.os.RemoteException;
public void onBeforeMain(java.lang.String[] commandLine) throws android.os.RemoteException;
public void onRunMain() throws android.os.RemoteException;
public void onDestroy() throws android.os.RemoteException;
}
