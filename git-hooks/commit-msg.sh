#!/bin/sh

commit_regex='(^\[[A-Z]{2,10}\-[0-9]{1,6}\]\s[a-zA-Z]+)|(Merge\s\w+)'
result=$(grep -E $commit_regex "$1")

error='
/***************************************************\
|            Wrong commit message pattern           |
|***************************************************|
| Please follow the pattern:                        |
| [<TEAM>-<ID_TICKET>]<Space>Message                |
| Example:                                          |
| [AB-123] Adding hooks.                            |
\***************************************************/'

if [ -z "${result}" ]; then
  echo "$error" >&2

  exit 1
fi