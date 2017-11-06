l = gets()
puts l.scan(/[C]{1,5}/).length + l.scan(/[P]{1,5}/).length
