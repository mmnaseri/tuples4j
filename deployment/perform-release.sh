#!/usr/bin/env bash

# If the merge commit message for the pull request being merged into master contains the line '$release:....$'
# the indicated module will be released into central.
main() {
  if [[ -n $(echo "${TRAVIS_COMMIT_MESSAGE}" | grep -E '\$release:.+\$') ]]; then
    local target
    target="$(echo "${TRAVIS_COMMIT_MESSAGE}" | grep -E '\$release:.+\$' | sed -E 's/\$release:(.*)\$/\1/')"
    if [[ ! -d "../${target}" ]];
    then
      echo "Cannot perform release on unknown target <${target}>"
      exit 1
    fi
    echo "Building the entire Maven reactor"
    cd "../tuples4j-build" || exit
    mvn install
    echo "Deploying target ${target}"
    cd "../${target}" || exit
    if [[ $TRAVIS_BRANCH == "master" ]]; then
      if [[ ("${TRAVIS_PULL_REQUEST}" == "false" || -z "${TRAVIS_PULL_REQUEST}") ]]; then
        if [[ "$(echo "${JAVA_HOME}" | grep -o 8)" == "8" ]]; then
          bash ../deployment/deploy.sh ab4567ade088 ../deployment/key.asc.enc ../deployment/settings.xml
        else
          echo "Not attempting to release ${target} since we are on JDK ${JAVA_HOME}"
        fi
      else
        echo "Not attempting to release ${target} since this is a pull request"
      fi
    else
      echo "Not attempting to release ${target} since this is the <${TRAVIS_BRANCH}> branch and not the <master> branch."
    fi
  else
    echo "Commit message does not match the pattern \$release:...\$. Ignoring release target."
  fi
}

main
