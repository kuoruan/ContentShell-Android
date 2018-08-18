#!/bin/sh

PROJECT_DIR="$(pwd)"

rm -rf ${PROJECT_DIR}/app/src/main/java/* \
	${PROJECT_DIR}/app/src/main/res/* \
	${PROJECT_DIR}/app/src/main/assets/* \
	${PROJECT_DIR}/app/src/main/jniLibs/*

rm -rf ${PROJECT_DIR}/content/src/main/res/* \
	${PROJECT_DIR}/content_shell/src/main/res/* \
	${PROJECT_DIR}/media/src/main/res/* \
	${PROJECT_DIR}/ui/src/main/res/*
	
rm -rf ${PROJECT_DIR}/components/embedder_support/src/main/java/* \
  ${PROJECT_DIR}/components/embedder_support/src/main/res/*
