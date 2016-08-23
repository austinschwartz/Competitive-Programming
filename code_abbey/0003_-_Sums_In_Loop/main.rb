a = []
ARGF.each_with_index do |line, i|
  if i > 0
    a << line.split[0].to_i + line.split[1].to_i
  end
end
puts a.join(' ')
