#!/bin/sh

set -e

CHROME_SRC="/home/liao/chromium/src"
BUILD_DIR="${CHROME_SRC}/out/Content"
GRADLE_DIR="${BUILD_DIR}/gradle"

PROJECT_DIR="$(pwd)/content"

rm -rf "${PROJECT_DIR}"
mkdir -p "${PROJECT_DIR}"

clean_dir() {
	rm -rf ${PROJECT_DIR}/app/src/main/java/test \
		${PROJECT_DIR}/app/src/main/java/templates \
		${PROJECT_DIR}/app/src/main/java/src

	local del_files="README|OWNERS|COPYING|.*\.template|R\.java|.*\.stamp|.*stamp\.d|.*\.py"
	find "$PROJECT_DIR" -regextype "posix-egrep" -regex ".*/(${del_files})" -type f -print0 | xargs -0 rm -f

	local empty_dirs;
	while :; do
		empty_dirs="$(find "$PROJECT_DIR" -type d -empty)"
		if [ -n "$empty_dirs" ]; then
			echo "$empty_dirs" | xargs rm -rf
		else
			break
		fi
	done
}

sync_sources(){
	local app_src="${PROJECT_DIR}/app/src/main/java"
	mkdir -p "$app_src"

	cp -r ${CHROME_SRC}/base/android/java/src/* \
		${CHROME_SRC}/build/android/buildhooks/java/* \
		${CHROME_SRC}/components/crash/android/java/src/* \
		${CHROME_SRC}/components/embedder_support/android/java/src/* \
		${CHROME_SRC}/components/location/android/java/src/* \
		${CHROME_SRC}/content/public/android/java/src/* \
		${CHROME_SRC}/content/shell/android/java/src/* \
		${CHROME_SRC}/content/shell/android/shell_apk/src/* \
		${CHROME_SRC}/device/bluetooth/android/java/src/* \
		${CHROME_SRC}/device/gamepad/android/java/src/* \
		${CHROME_SRC}/device/usb/android/java/src/* \
		${CHROME_SRC}/media/base/android/java/src/* \
		${CHROME_SRC}/media/capture/content/android/java/src/* \
		${CHROME_SRC}/media/capture/video/android/java/src/* \
		${CHROME_SRC}/media/midi/java/src/* \
		${CHROME_SRC}/mojo/public/java/base/src/* \
		${CHROME_SRC}/mojo/public/java/bindings/src/* \
		${CHROME_SRC}/mojo/public/java/system/src/* \
		${CHROME_SRC}/net/android/java/src/* \
		${CHROME_SRC}/services/device/android/java/src/* \
		${CHROME_SRC}/services/device/battery/android/java/src/* \
		${CHROME_SRC}/services/device/generic_sensor/android/java/src/* \
		${CHROME_SRC}/services/device/geolocation/android/java/src/* \
		${CHROME_SRC}/services/device/nfc/android/java/src/* \
		${CHROME_SRC}/services/device/public/java/src/* \
		${CHROME_SRC}/services/device/screen_orientation/android/java/src/* \
		${CHROME_SRC}/services/device/time_zone_monitor/android/java/src/* \
		${CHROME_SRC}/services/device/vibration/android/java/src/* \
		${CHROME_SRC}/services/device/wake_lock/power_save_blocker/android/java/src/* \
		${CHROME_SRC}/services/service_manager/public/java/src/* \
		${CHROME_SRC}/services/shape_detection/android/java/src/* \
		${CHROME_SRC}/third_party/android_async_task/java/src/* \
		${CHROME_SRC}/ui/android/java/src/* \
		${app_src}

	cp -r ${GRADLE_DIR}/content/shell/android/content_shell_apk/extracted-srcjars/* \
		${app_src}

	cp ${BUILD_DIR}/gen/content/shell/android/content_shell_manifest/AndroidManifest.xml \
		${PROJECT_DIR}/app/src/main
}

sync_res () {
	local content_public_res="${PROJECT_DIR}/content/src/main/res"
	mkdir -p "$content_public_res"
	cp -r ${CHROME_SRC}/content/public/android/java/res/* \
		${BUILD_DIR}/gen/content/public/android/content_strings_grd_grit_output/* \
		${content_public_res}

	local content_shell_res="${PROJECT_DIR}/content_shell/src/main/res"
	mkdir -p "$content_shell_res"
	cp -r ${CHROME_SRC}/content/shell/android/shell_apk/res/* \
		${CHROME_SRC}/content/shell/android/java/res/* \
		${content_shell_res}

	local content_shell_apk_res="${PROJECT_DIR}/app/src/main/res"
	mkdir -p "$content_shell_apk_res"
	cp -r ${CHROME_SRC}/content/shell/android/shell_apk/res/* \
		${content_shell_apk_res}

	local media_res="${PROJECT_DIR}/media/src/main/res"
	mkdir -p "$media_res"
	cp -r ${CHROME_SRC}/media/base/android/java/res/* \
		${media_res}

	local ui_res="${PROJECT_DIR}/ui/src/main/res"
	mkdir -p "$ui_res"

	cp -r ${CHROME_SRC}/ui/android/java/res/* \
		#${BUILD_DIR}/gen/ui/android/ui_strings_grd_grit_output/* \
		${GRADLE_DIR}/content/shell/android/content_shell_apk/extracted-res/* \
		${ui_res}

	local embedder_support_res="${PROJECT_DIR}/components/embedder_support/src/main/res"
	mkdir -p "$embedder_support_res"
	cp -r ${CHROME_SRC}/components/embedder_support/android/java/res/* \
		${CHROME_SRC}/out/Webview/gen/components/embedder_support/android/web_contents_delegate_strings_grd_grit_output/* \
		#${BUILD_DIR}/gen/components/embedder_support/android/web_contents_delegate_strings_grd_grit_output/* \
		${embedder_support_res}
}

sync_bin_files () {
	local app_assets="${PROJECT_DIR}/app/src/main/assets"
	local app_jni_lib="${PROJECT_DIR}/app/src/main/jniLibs/armeabi-v7a"
	mkdir -p "$app_assets" "$app_jni_lib"

	cp ${BUILD_DIR}/libcontent_shell_content_view.so \
		${BUILD_DIR}/libosmesa.so \
		${app_jni_lib}

	cp ${BUILD_DIR}/icudtl.dat \
		${BUILD_DIR}/content_shell.pak \
		${BUILD_DIR}/natives_blob.bin \
		${app_assets}

	cp ${BUILD_DIR}/snapshot_blob.bin ${app_assets}/snapshot_blob_32.bin
}

sync_sources
sync_res
sync_bin_files
clean_dir
