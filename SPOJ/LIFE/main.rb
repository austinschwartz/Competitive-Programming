#!/usr/bin/env ruby

ARGF.each do |line|
  if line.eql? "42\n" then
    exit
  end
  print line
end
